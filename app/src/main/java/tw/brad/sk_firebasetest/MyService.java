package tw.brad.sk_firebasetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private Timer timer;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        timer.schedule(new MyGoodJob(), 10*1000);
    }

    private class MyGoodJob extends TimerTask {
        @Override
        public void run() {

        }
    }

}
