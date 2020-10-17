package mobile.learning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListMahasiswaPertemuanActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    TextView txt_username,txt_nama;
    public static String idclass,username,nameclass,code,pertemuan;
    ArrayAdapter<String> adapter;
    String e[] = {"Pertemuan 1","Pertemuan 2","Pertemuan 3","Pertemuan 4","Pertemuan 5","Pertemuan 6","Pertemuan 7","Pertemuan 8"
            ,"Pertemuan 9","Pertemuan 10","Pertemuan 11","Pertemuan 12","Pertemuan 13","Pertemuan 14"};

    public static String idjoin,username_host,username_client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa_pertemuan);

        listView = (ListView) findViewById(R.id.list_view);

        adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, e);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        Intent intent = getIntent();

        idjoin = intent.getStringExtra(Server.TAG_ID);
        idclass = intent.getStringExtra(Server.TAG_IDCLASS);
        username_host = intent.getStringExtra(Server.TAG_USERNAME_HOST);
        nameclass = intent.getStringExtra(Server.TAG_NAMECLASS);
        username_client = intent.getStringExtra(Server.TAG_USERNAME_CLIENT);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, adapter.getItem(position), Toast.LENGTH_SHORT).show();

        pertemuan = e[position];
        Intent intent = new Intent(this, DisplayTaskActivity.class);

        intent.putExtra(Server.TAG_ID,idjoin);
        intent.putExtra(Server.TAG_IDCLASS,idclass);
        intent.putExtra(Server.TAG_USERNAME,username_host);
        intent.putExtra(Server.TAG_NAMECLASS,nameclass);
        intent.putExtra("pertemuan",pertemuan);
        intent.putExtra("username_client", username_client);
        startActivity(intent);

    }
}
