package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater; import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class PatientAdapter  extends BaseAdapter {
    private Context mContext;
    Controllerdb controllerdb;
    private ArrayList<String> stdId = new ArrayList<String>();
    private ArrayList<String> stdAge = new ArrayList<String>();
    private ArrayList<String> stdName = new ArrayList<String>();
    private ArrayList<String> Id = new ArrayList<String>();
    public PatientAdapter(Context mContext, ArrayList<String> Id, ArrayList<String> stdName, ArrayList<String> stdId, ArrayList<String> stdAge) {
        this.mContext = mContext;
        this.Id = Id;
        this.stdName = stdName;
        this.stdId = stdId;
        this.stdAge = stdAge; }
    @Override public int getCount() {
        return Id.size();
    }
    @Override public Object getItem(int position) {
        return null;
    }
    @Override public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PatientViewHolder holder;
        controllerdb = new Controllerdb(mContext);
        LayoutInflater layoutInflater;
        if (convertView == null) {
      layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_row, null);
            holder = new PatientViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.tvid);
            holder.name = (TextView) convertView.findViewById(R.id.tvname);
            holder.patient_id = (TextView) convertView.findViewById(R.id.tvstdid);
            holder.patient_age = (TextView)
                    convertView.findViewById(R.id.tvstdage);
                    convertView.setTag(holder);
        } else {
            holder = (PatientViewHolder) convertView.getTag();
        }
        holder.id.setText(Id.get(position));
        holder.name.setText(stdName.get(position));
        holder.patient_id.setText(stdId.get(position));
        holder.patient_age.setText(stdAge.get(position));
        return convertView;
    }
}
