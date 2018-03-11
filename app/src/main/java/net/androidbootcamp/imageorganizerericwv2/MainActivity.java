package net.androidbootcamp.imageorganizerericwv2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Motivation = {R.drawable.iwantitbad, R.drawable.believe, R.drawable.dream, R.drawable.drive, R.drawable.imagination, R.drawable.results};
    ImageView pic;
    //    to declare ImageView as a class variable, type ImageView Pic
//    ImageView is initialized
//    ch5 adapter was used to display listview control
//    setAdapter for imageAdapter
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.newImage);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext()," Motivation "+ (position+1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Motivation[position]);
            }
        });
    }

//    to add ImageAdapter class that extends BaseAdapter
//    Alt+Return to implement methods

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private ImageAdapter(Context c){
            context=c;
        }

        @Override
        public int getCount() {
            return Motivation.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Motivation[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(270,300));
            return pic;
        }
    }

}