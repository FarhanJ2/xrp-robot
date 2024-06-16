// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ArmStatus;
import frc.robot.Constants;

public class XRPArm extends SubsystemBase {
	private final XRPServo m_arm = new XRPServo(Constants.ArmConstants.kServoPort);
	public ArmStatus m_armStatus = ArmStatus.INIT;

	/** Creates a new XRPArm. */
	public XRPArm() {
	}

	public void setArmPosition(double position) {
		if (m_armStatus == ArmStatus.MOVING) return;

		position = Math.max(0.0, Math.min(1.0, position));
		m_arm.setPosition(position);

		if (position == 0.0) {
			m_armStatus = ArmStatus.RETRACTED;
		} else {
			m_armStatus = ArmStatus.EXTENDED;
		}
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
