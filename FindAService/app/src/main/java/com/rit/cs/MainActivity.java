package com.rit.cs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ImageButton PROVIDER, CONSUMER;
    TextView ProviderLbl, ConsumerLbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PROVIDER = (ImageButton) findViewById(R.id.provider);
        ProviderLbl = (TextView) findViewById(R.id.providerlbl);
        PROVIDER.setOnClickListener(providerPage);
        ProviderLbl.setOnClickListener(providerPage);
        CONSUMER = (ImageButton) findViewById(R.id.consumer);
        ConsumerLbl = (TextView) findViewById(R.id.consumerlbl);
        CONSUMER.setOnClickListener(consumerPage);
        ConsumerLbl.setOnClickListener(consumerPage);
    }

    View.OnClickListener providerPage = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent newProvider = new Intent(MainActivity.this,ProviderActivity.class);
            startActivity(newProvider);
        }
    };
    View.OnClickListener consumerPage= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent newConsumer = new Intent(MainActivity.this,ConsumerActivity.class);
            startActivity(newConsumer);
        }
    };
}
