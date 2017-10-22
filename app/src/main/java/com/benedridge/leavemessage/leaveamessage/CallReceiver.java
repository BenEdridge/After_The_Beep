package com.benedridge.leavemessage.leaveamessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallReceiver extends BroadcastReceiver {

    private static int lastState = TelephonyManager.CALL_STATE_IDLE;
    private static String callee;
    private static String number;

    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("Phone state changed");

        //If incoming call
        if(!intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL"))
        {
            //Get number and state
            String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if(stateStr.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                Toast.makeText(context, "IDLE", Toast.LENGTH_SHORT).show();
            }
            else if(stateStr.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                Toast.makeText(context, "OFFHOOK", Toast.LENGTH_SHORT).show();
            }
            else if(stateStr.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                Toast.makeText(context, "RINGING", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
