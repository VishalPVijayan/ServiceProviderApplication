package com.vishalpvijayan.serviceproviderapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class ContentActivity extends AppCompatActivity {

    CardView cardViewPlumb,cardViewElectricity,cardViewCleaning,cardViewCarpenter,cardViewelectric_repair,cardViewBrush,cardViewSpa,cardViewSaloon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        cardViewPlumb = findViewById(R.id.cardViewPlumb);
        cardViewElectricity = findViewById(R.id.cardViewElectricity);
        cardViewCleaning = findViewById(R.id.cardViewCleaning);
        cardViewCarpenter = findViewById(R.id.cardViewCarpenter);
        cardViewelectric_repair = findViewById(R.id.cardViewelectric_repair);
        cardViewBrush = findViewById(R.id.cardViewBrush);
        cardViewSpa = findViewById(R.id.cardViewSpa);
        cardViewSaloon = findViewById(R.id.cardViewSaloon);

        cardViewPlumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlumb();
            }
        });

        cardViewElectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        cardViewCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClean();
            }
        });

        cardViewCarpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCarpenter();
            }
        });

        cardViewelectric_repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRepair();
            }
        });

        cardViewBrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrush();
            }
        });

        cardViewSpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpa();
            }
        });

        cardViewSaloon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSaloon();
            }
        });

    }

    private void openPlumb() {
        PlumbingDialog plumbingDialog = new PlumbingDialog();
        plumbingDialog.show(getSupportFragmentManager(),"Plumbing Dialog");
    }

    private void openClean() {
        CleaningDialog cleaningDialog = new CleaningDialog();
        cleaningDialog.show(getSupportFragmentManager(),"cleaning Dialog");
    }

    private void openCarpenter() {
        CarpentersDialog carpentersDialog = new CarpentersDialog();
        carpentersDialog.show(getSupportFragmentManager(),"Carpenter Dialog");
    }

    private void openRepair() {
        AppliancesDialog appliancesDialog = new AppliancesDialog();
        appliancesDialog.show(getSupportFragmentManager(),"Appliance Dialog");
    }

    private void openBrush() {
        PaintersDialog paintersDialog = new PaintersDialog();
        paintersDialog.show(getSupportFragmentManager(),"Painters Dialog");
    }

    private void openSaloon() {
        SalonDialog salonDialog = new SalonDialog();
        salonDialog.show(getSupportFragmentManager(),"Salon Dialog");
    }

    private void openSpa() {
        SpaDialog spaDialog = new SpaDialog();
        spaDialog.show(getSupportFragmentManager(),"Spa Dialog");

    }

    private void openDialog() {
        ElectricalDialog electricalDialog = new ElectricalDialog();
        electricalDialog.show(getSupportFragmentManager(),"Electrical Dialog");
    }
}