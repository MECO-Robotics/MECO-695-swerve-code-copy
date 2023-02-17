// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlapManipulatorSubsystem;

public class RunFlapManipulatorCommand extends CommandBase 
{
  private final FlapManipulatorSubsystem m_FlapManipulatorSubsystem;

  private boolean deploy;

  public RunFlapManipulatorCommand(FlapManipulatorSubsystem FlapManipulatorSubsystem, boolean deploy) 
  {
    this.m_FlapManipulatorSubsystem = FlapManipulatorSubsystem;
    this.deploy = deploy;
    addRequirements(m_FlapManipulatorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    if (deploy == true)
    {
      if (m_FlapManipulatorSubsystem.getPosition() < 6)
      {
        m_FlapManipulatorSubsystem.setSpeed(0.2);
      }
      else
      {
        m_FlapManipulatorSubsystem.setSpeed(0.05);
      }
    }
    else
    {
      if (m_FlapManipulatorSubsystem.getPosition() > 0)
      {
        m_FlapManipulatorSubsystem.setSpeed(-0.1);
      }
      else
      {
        m_FlapManipulatorSubsystem.setSpeed(-0.05);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return false;
  }
}
