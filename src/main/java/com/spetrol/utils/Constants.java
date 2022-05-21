package com.spetrol.utils;

public interface Constants {

	String SIGN_IN="//*[@class='android.widget.TextView' and @text='Sign In']";
	String TxtBox_MobileNumber = "//*[@class='android.widget.EditText']";
	String Btn_NextAfterMobNum = "//*[@class='android.widget.TextView' and @text='Next']";
	String TxtBox_OTP="(//*[@class='android.widget.EditText'])[%d]";
	String Btn_VerifyOTP="//*[@class='android.widget.TextView' and @text='Verify OTP']";
	String Btn_Hamburger="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup";
	String Lnk_Logout="//*[@class='android.widget.TextView' and @text='Log out']";
	String Btn_Yes="//*[@class='android.widget.TextView' and @text='YES']";
	String Cust_Name="//*[@class='android.widget.TextView' and @index='1']";
	String Cust_Num="//*[@class='android.widget.TextView' and @index='2']";
	String Lnk_Assets="//android.widget.TextView[@text='Assets']";
	String Btn_AddNewAssets="//android.widget.TextView[@text='Add new asset']";
	String Img_IndustMachinery = "(//*[@class='android.widget.ImageView'])[2]";
	String Btn_ContinueVehicleSelection ="//*[@class='android.widget.TextView' and @text='Continue']";
	String TxtBox_FuelCapacity="//*[@class='android.widget.EditText' and @text='Fuel Capacity']";
	String Btn_SaveAsset="//*[@class='android.widget.TextView' and @text='Save Asset']";
	String Lnk_UpdateAssetIndusMach ="//android.widget.TextView[@text='Industrial Machinery']";
	String TxtBox_UpdatedFuel ="(//android.widget.EditText)[3]";
	String Btn_UpdateAsset="//*[@text='Update']";
	String Lnk_EditAsset ="//*[@text='Edit']";
	String Lnk_DeleteAsset="(//*[@text='Delete'])[2]";
	String Btn_DeleteConfirm="//*[@text='DELETE']";
}
