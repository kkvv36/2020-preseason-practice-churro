/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;

public class testControlPanel extends CommandBase {

  private ControlPanel controlPanelSubsystem;

  /**
   * Creates a new testColorSensor.
   */
  public testControlPanel() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    controlPanelSubsystem.setColorSensor();
    controlPanelSubsystem.setMotor();
    controlPanelSubsystem.wheelSpinning();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    controlPanelSubsystem.colorCalibration();

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {  
    controlPanelSubsystem.wheelNotSpinning();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
