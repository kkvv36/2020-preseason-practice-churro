package org.usfirst.frc5409.Testrobot.subsystems;

import org.usfirst.frc5409.Testrobot.util.Range;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc5409.Testrobot.commands.*;


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

public class Drivetrain extends Subsystem {
//===================================================================
//CONFIGURATIONS

    public static final Range<Double> c_velocity_range_m =
        new Range(-5, 5);

//===================================================================
//ROBOT BUILDER

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_VictorSPX m_leftDrive_Victor_SPX_C20;
    private WPI_VictorSPX m_rightDrive_Victor_SPX_C21;
    private DifferentialDrive differentialDrive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    public static final double c_Drivetrain_Wheel_Diamater_in = 6;
    public static final double c_Drivetrain_Gear_Ratio = 10.71;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

//===================================================================
//PRE-CALCULATED CONSTANTS

    public static final double c_Distance_Per_Pulse = 
        (Math.PI * c_Drivetrain_Wheel_Diamater_in) / (c_Drivetrain_Gear_Ratio*4);

//===================================================================
//MEMBER VARIABLES

    private double m_wheel_velocity_R = 0;
    private double m_wheel_velocity_L = 0;

    private Object m_this_mutex = new Object();
//===================================================================

    public Drivetrain() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        m_leftDrive_Victor_SPX_C20 = new WPI_VictorSPX(20);
        m_rightDrive_Victor_SPX_C21 = new WPI_VictorSPX(21);
        
        differentialDrive = new DifferentialDrive(m_leftDrive_Victor_SPX_C20, m_rightDrive_Victor_SPX_C21);
        addChild("Differential Drive",differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        //setDefaultCommand(new Drive());
    }

    @Override
    public void periodic() {
        final double velocity_L;
        final double velocity_R;

        synchronized(m_this_mutex) {
            velocity_L = m_wheel_velocity_L;
            velocity_R = m_wheel_velocity_R;
        }

        differentialDrive.tankDrive(velocity_L, velocity_R);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    public void arcadeDrive(double speed_X, double rotation_Z) {
        double left_motor_output;
        double right_motor_output;

        limit(speed_X);
        limit(rotation_Z);

        //Might have to flip these for some reason
        speed_X = Math.copySign(speed_X * speed_X, speed_X);
        rotation_Z = Math.copySign(rotation_Z * rotation_Z, rotation_Z);

        final double maxInput = Math.copySign(
            Math.max(Math.abs(speed_X), Math.abs(rotation_Z)), speed_X);
    
        if (speed_X >= 0.0) {
            if (rotation_Z >= 0.0) {
                left_motor_output = maxInput;
                right_motor_output = speed_X - rotation_Z;
            } else {
                left_motor_output = speed_X + rotation_Z;
                right_motor_output = maxInput;
            }
        } else {
            if (rotation_Z >= 0.0) {
                left_motor_output = speed_X + rotation_Z;
                right_motor_output = maxInput;
            } else {
                left_motor_output = maxInput;
                right_motor_output = speed_X - rotation_Z;
            }
        }
    
        synchronized(m_this_mutex) {
            m_wheel_velocity_L = left_motor_output;
            m_wheel_velocity_R = -right_motor_output;
        }
    }

    public void tankDrive(double speed_L, double speed_R) {
        synchronized(m_this_mutex) {
            m_wheel_velocity_L = speed_L;
            m_wheel_velocity_R = speed_R;
        }
    }

    public void reset() {
        synchronized(m_this_mutex) {
            m_wheel_velocity_L = 0;
            m_wheel_velocity_R = 0;
        }
    }

    private double limit(double value) {
        if (value > 1)
            return 1;
        else if (value < 0)
            return 0;
        return value;
    }
}

