package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.makedu.studentscompanion.R;

import java.util.ArrayList;

import model.Schools;

public class CustomGridViewAdapter extends ArrayAdapter<Schools>{
Context context;
int layoutResourceId;
ArrayList<Schools> data = new ArrayList<Schools>();
	
	public CustomGridViewAdapter(Context context, int layoutResourceId,
			ArrayList<Schools> data) {
		super(context, layoutResourceId,data);
	this.context = context;
	this.layoutResourceId = layoutResourceId;
	this.data = data;
	}
	
	
	
	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			RecordHolder holder = null;
			
			if(row == null){
				LayoutInflater inflater = ((Activity) context).getLayoutInflater(); 
				row = inflater.inflate(layoutResourceId, parent, false);
				
				holder = new RecordHolder();
				holder.txtTitle = (TextView) row.findViewById(R.id.home_image);
				holder.imageItem = (ImageView) row.findViewById(R.id.img_thumbnail);
				row.setTag(holder);
			}else
			{
				holder = (RecordHolder) row.getTag();
			}
		
			Schools schools = data.get(position);
			holder.txtTitle.setText(schools.getName());
			holder.imageItem.setImageBitmap(schools.getThumbnail());

			    return row;
		
		}

	static class RecordHolder {
			  TextView txtTitle;
			  ImageView imageItem;
			 
			 }
}
