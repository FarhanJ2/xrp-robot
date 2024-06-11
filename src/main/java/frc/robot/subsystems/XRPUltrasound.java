// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPRangefinder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class XRPUltrasound extends SubsystemBase {
	private final XRPRangefinder m_rangeFinder = new XRPRangefinder();
 
	/** Creates a new XRPUltrasound. */
	public XRPUltrasound() {
		
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run

	}

	/**
	 * Returns the distance measured by the XRPUltrasound in centimeters.
	 */
	public double getDistance() {
		return m_rangeFinder.getDistanceInches() * 2.54f;
	}
}
