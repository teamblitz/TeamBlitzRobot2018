package org.usfirst.frc.team2083.robot;

public final class TargetTracker
{
	public static boolean isTracking()
	{
		return RobotMap.targetTrackingTable.getBoolean(RobotMap.TARGET_TRACKING_TABLE_KEY_TRACKING, false);
	}
	
	public static long getX()
	{
		double[] defaultValues = {0, 0};
		double[] center = RobotMap.targetTrackingTable.getNumberArray(RobotMap.TARGET_TRACKING_TABLE_KEY_TARGET_CENTER, defaultValues);
		return (long)center[0];
	}
	
	public static long getY()
	{
		double[] defaultValues = {0, 0};
		double[] center = RobotMap.targetTrackingTable.getNumberArray(RobotMap.TARGET_TRACKING_TABLE_KEY_TARGET_CENTER, defaultValues);
		return (long)center[1];
	}
	
	public static long getArea()
	{
		return (long)RobotMap.targetTrackingTable.getNumber(RobotMap.TARGET_TRACKING_TABLE_KEY_TARGET_AREA, 0);
	}
	
	public static void reset()
	{
		RobotMap.targetTrackingTable.putBoolean(RobotMap.TARGET_TRACKING_TABLE_KEY_TRACKING, false);
		RobotMap.targetTrackingTable.putNumberArray(RobotMap.TARGET_TRACKING_TABLE_KEY_TARGET_CENTER, new double[] {0.0, 0.0} );
		RobotMap.targetTrackingTable.putNumberArray(RobotMap.TARGET_TRACKING_TABLE_KEY_TARGET_RECT, new double[] {0.0, 0.0, 0.0, 0.0} );
		RobotMap.targetTrackingTable.putNumber(RobotMap.TARGET_TRACKING_TABLE_KEY_TARGET_AREA, 0);
	}
}
