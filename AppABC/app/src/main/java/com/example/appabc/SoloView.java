package com.example.appabc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appabc.model.project.ProjectModel;

import java.util.List;

/**
 * @Autor Alan
 * @version 1.0
 */

public class SoloView extends ArrayAdapter<ProjectModel> {

    private Context context;
    private  List<ProjectModel> projectModels;

    public SoloView(@NonNull Context context, int resource, @NonNull List<ProjectModel> objects) {
        super(context, resource, objects);
        this.context=context;
        this.projectModels =objects;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.content_main,parent,false);

        TextView txtIdProject=(TextView)rowView.findViewById(R.id.textViewIdProject);
        TextView txtNameProject=(TextView)rowView.findViewById(R.id.textViewNameProject);;
        TextView txtProjectManager=(TextView)rowView.findViewById(R.id.textViewProjectManager);;
        TextView txtDescription=(TextView)rowView.findViewById(R.id.textViewDescription);
        TextView txtDevelopers=(TextView)rowView.findViewById(R.id.textViewDevelopers);;

        txtIdProject.setText(String.format("ID: %d", projectModels.get(position).getIdproject()));
        txtNameProject.setText(String.format("nameProject: %s", projectModels.get(position).getNameproject()));
        txtProjectManager.setText(String.format("projectManager: %s", projectModels.get(position).getProjectmanager()));
        txtDescription.setText(String.format("description: %s", projectModels.get(position).getDescription()));
        txtDevelopers.setText(String.format("developers: %s", projectModels.get(position).getDevelopers()));
/*
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ProjectActivity.class);
                intent.putExtra("ID",String.valueOf(projectModels.get(position).getIdproject()));
                intent.putExtra("nameProject", projectModels.get(position).getNameproject());
                intent.putExtra("projectManager", projectModels.get(position).getProjectmanager());
                intent.putExtra("description", projectModels.get(position).getDescription());
                intent.putExtra("developers", projectModels.get(position).getDevelopers());
                context.startActivity(intent);
            }
        });*/
        return rowView;

    }

}