package tw.brad.sk_firebasetest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        myRef.addValueEventListener(new MyValueListener());

    }

    public void test1(View view) {
        Student s1 = new Student(95,40,20);
        DatabaseReference d1 = database.getReference("s1");
        d1.setValue(s1);
        d1.addValueEventListener(new MyValueListener());
    }

    private class MyValueListener implements ValueEventListener {

        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String key = dataSnapshot.getRef().getKey();
            if (key.equals("message")) {
                String value = dataSnapshot.getValue(String.class);
                Log.v("brad", value);
            }else if (key.equals("s1")){
                Student s1 = dataSnapshot.getValue(Student.class);
                double score = s1.calScore();
                double avg = s1.calAvg();
                Log.v("brad", score + ":" + avg);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    }


}
