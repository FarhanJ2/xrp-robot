// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.XRPArm;
import frc.robot.subsystems.XRPDrivetrain;
import frc.robot.subsystems.XRPUltrasound;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveArm;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
	// subsystems
	public static final XRPDrivetrain m_xrpDrivetrain = new XRPDrivetrain();
	public static final XRPUltrasound m_xrpUltrasound = new XRPUltrasound();
	public static final XRPArm m_xrpArm = new XRPArm();

	// commands
	private final ExampleCommand m_autoCommand = new ExampleCommand();

	// controls
	public static final CommandXboxController m_driverController = new CommandXboxController(0);

	private final Trigger t_scanObjectDistance = m_driverController.a();
	private final Trigger t_moveArm = m_driverController.leftBumper(); 

	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Configure the button bindings
		configureButtonBindings();
	}

	/**
	 * Use this method to define your button->command mappings. Buttons can be
	 * created by
	 * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
	 * subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
	 * it to a {@link
	 * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() {
		t_moveArm.whileTrue(new MoveArm());
		t_scanObjectDistance.whileTrue(new InstantCommand(() -> {
			System.out.println("Object Distance: " + m_xrpUltrasound.getDistance());
		}));
	}

	public void controlBot() {
		m_xrpDrivetrain.arcadeDrive(-m_driverController.getRawAxis(1), -m_driverController.getRawAxis(4));
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		// An ExampleCommand will run in autonomous
		return m_autoCommand;
	}
}
 