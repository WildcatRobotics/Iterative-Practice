package org.usfirst.frc.team6171.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	Joystick joy;
	JoystickButton X;
	JoystickButton A;
	JoystickButton B;
	JoystickButton Y;
	
	public OI(){
		joy = new Joystick(0);
		X = new JoystickButton(joy, 1);
		A = new JoystickButton(joy, 2);
		B = new JoystickButton(joy, 3);
		Y = new JoystickButton(joy, 4);
	}
}
