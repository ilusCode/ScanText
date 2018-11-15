package com.scantext.ilus.scantext;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    Bitmap bmp;
    ImageView img;
    Intent i;
    static int cons = 0;
    CheckBox cbCorreo;
    CheckBox cbDireccion;
    CheckBox cbEdad;
    CheckBox cbNombre;
    CheckBox cbSala;
    CheckBox cbTelefono;
    CheckBox cbFConsulta;
    CheckBox cbTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        init();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                switch (id) {
                    case R.id.fab:

                        i = new Intent(MainActivity.this, CameraSurface.class);
                        cbCorreo = (CheckBox) findViewById(R.id.idCheckBox_Correo);
                        cbDireccion = (CheckBox) findViewById(R.id.idCheckBox_Direccion);
                        cbEdad = (CheckBox) findViewById(R.id.idCheckBox_Edad);
                        cbFConsulta = (CheckBox) findViewById(R.id.idCheckBox_FConsulata);
                        cbNombre = (CheckBox) findViewById(R.id.idCheckBox_Nombre);
                        cbSala = (CheckBox) findViewById(R.id.idCheckBox_Sala);
                        cbTelefono = (CheckBox) findViewById(R.id.idCheckBox_Telefono);
                        cbTodo = (CheckBox) findViewById(R.id.idCheckBox_Todo);

                        i.putExtra("idCorreo", cbCorreo.isChecked());
                        i.putExtra("idDireccion", cbDireccion.isChecked());
                        i.putExtra("idEdad", cbEdad.isChecked());
                        i.putExtra("idFConsulta", cbFConsulta.isChecked());
                        i.putExtra("idNombre", cbNombre.isChecked());
                        i.putExtra("idSala", cbSala.isChecked());
                        i.putExtra("idTelefono", cbTelefono.isChecked());
                        i.putExtra("idTodo", cbTodo.isChecked());

                        startActivity(i);


                        //i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        // startActivityForResult(i,cons);

                        break;
                }

            }
        });
    }

    public void init() {
        img = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {

            cbCorreo = (CheckBox) findViewById(R.id.idCheckBox_Correo);
            cbDireccion = (CheckBox) findViewById(R.id.idCheckBox_Direccion);
            cbEdad = (CheckBox) findViewById(R.id.idCheckBox_Edad);
            cbFConsulta = (CheckBox) findViewById(R.id.idCheckBox_FConsulata);
            cbNombre = (CheckBox) findViewById(R.id.idCheckBox_Nombre);
            cbSala = (CheckBox) findViewById(R.id.idCheckBox_Sala);
            cbTelefono = (CheckBox) findViewById(R.id.idCheckBox_Telefono);
            cbTodo = (CheckBox) findViewById(R.id.idCheckBox_Todo);
            if (cbCorreo.isChecked() == true) {
                Toast.makeText(getBaseContext(), "Correo: " + cbCorreo.toString(), Toast.LENGTH_SHORT).show();
            }
            if (cbDireccion.isChecked() == true) {
                Toast.makeText(getBaseContext(), "Dirección: " + cbDireccion.toString(), Toast.LENGTH_SHORT).show();
            }
            if (cbEdad.isChecked() == true) {
                Toast.makeText(getBaseContext(), "Edad: " + cbEdad.toString(), Toast.LENGTH_SHORT).show();
            }
            if (cbFConsulta.isChecked() == true) {
                Toast.makeText(getBaseContext(), "Fecha de Consulta: " + cbFConsulta.toString(), Toast.LENGTH_SHORT).show();
            }
            if (cbNombre.isChecked() == true) {
                Toast.makeText(getBaseContext(), "Nombre: " + cbNombre.toString(), Toast.LENGTH_SHORT).show();
            }
            if (cbSala.isChecked() == true) {
                Toast.makeText(getBaseContext(), "Sala: " + cbSala.toString(), Toast.LENGTH_SHORT).show();
            }
            if (cbTelefono.isChecked() == true) {
                Toast.makeText(getBaseContext(), "Telefono: " + cbTelefono.toString(), Toast.LENGTH_SHORT).show();
            }
            if (cbTodo.isChecked() == true) {
                Toast.makeText(getBaseContext(), "Todo: " + cbTodo.toString(), Toast.LENGTH_SHORT).show();
            }

            Intent i = new Intent(MainActivity.this, ViewCamera.class);
            i.putExtra("idCorreo", cbCorreo.isChecked());
            i.putExtra("idDireccion", cbDireccion.isChecked());
            i.putExtra("idEdad", cbEdad.isChecked());
            i.putExtra("idFConsulta", cbFConsulta.isChecked());
            i.putExtra("idNombre", cbNombre.isChecked());
            i.putExtra("idSala", cbSala.isChecked());
            i.putExtra("idTelefono", cbTelefono.isChecked());
            i.putExtra("idTodo", cbTodo.isChecked());

            Bundle b = data.getExtras();
            bmp = (Bitmap) b.get("data");
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 50, bs);
            b.putByteArray("imagetext", bs.toByteArray());
            i.putExtras(b);

            //bmp=(Bitmap)extra.get("data");
            //img.setImageBitmap(bmp);

            startActivity(i);
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Tab1_InformationActivity informacion = new Tab1_InformationActivity();
                    return informacion;
                case 1:
                    Tab2_settingsActivity ajustes = new Tab2_settingsActivity();
                    return ajustes;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Infomación";
                case 1:
                    return "Ajustes";
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        super.finish();
        System.exit(0);
    }

}
