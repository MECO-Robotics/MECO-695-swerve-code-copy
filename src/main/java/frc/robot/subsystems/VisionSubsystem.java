// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import org.photonvision.PhotonCamera;
//import org.photonvision.targeting.PhotonPipelineResult;
//import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {

  //PhotonCamera camera = new PhotonCamera("OV5647");
//  PhotonTrackedTarget target;

  boolean hasTargets;
  double pitch;
  double yaw;
  double area;

  public VisionSubsystem(NetworkTableInstance RobotMainNetworkTableInstance, int driverNum) 
  {
  }

  /*public void getBestTarget()
  {
    var result = camera.getLatestResult();
    hasTargets = result.hasTargets();

    if(hasTargets)
    {
      var targlist = result.getTargets();
      var numTarg = targlist.size();
      target = result.getBestTarget();
      //target = targlist.get(0);
      //if (1 < numTarg)
      //{
      //  double bestarea = 0;
      //  double bestyaw = target.getYaw();
        //target = targ
      //}
    }
  }*/

  public boolean hasTarget()
  {
    boolean ret = false;
    double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    if(tv == 1){
      if(ty < -5.5){
        if(tx > -15){
          ret = true;
        }
      } 
      else {
        if(tx > -13){
          ret = true;
        }
      }
    }
    return(ret);
  }

  public double getPitch()
  {
    return(0);
  }

  public double getYaw()
  {
    return(0);
  }

  public double getArea()
  {
    return(0);
  }

  @Override
  public void periodic() 
  {
    SmartDashboard.putBoolean("Target", hasTarget());
      //SmartDashboard.putNumber("Pitch", getPitch());
      //SmartDashboard.putNumber("Yaw", getYaw());
      //SmartDashboard.putNumber("Area",getArea());  
      //periodicHasTarget = hasTarget(); 
      //periodicYaw = getYaw();
  }
}
