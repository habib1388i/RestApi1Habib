package com.example.restapi1habib;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.restapi1habib.Fragment.FragmentPertandingan;
import com.example.restapi1habib.Fragment.FragmentTeam;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new FragmentTeam());
        BottomNavigationView bottomNavigationView = findViewById(R.id.cup);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragmentTeam) {
        if (fragmentTeam != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragmentTeam)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.item_team:
                fragment = new FragmentTeam();
                break;
            case R.id.item_pertandingan:
                fragment = new FragmentPertandingan();
                break;
        }

        return loadFragment(fragment);

    }

}

//       private void caseAlertDialog(){
//           AlertDialog.Builder builder = new AlertDialog.Builder(this)
//                   .setMessage("Close this Application ?")
//                   .setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                       @Override
//                       public void onClick(DialogInterface dialog, int which) {
//                           dialog.dismiss();
//                       }
//                   }).setPositiveButton("Ya", new DialogInterface.OnClickListener() {
//                       @Override
//                       public void onClick(DialogInterface dialog, int which) {
//                           dialog.dismiss();
//                           finish();
//                       }
//                   });
//           AlertDialog dialog = builder.create();
//           dialog.show();

