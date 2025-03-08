package vn.tiendung.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NotesAdapter extends BaseAdapter {
    private MainActivity context; // Sử dụng MainActivity để gọi hàm DialogCapNhatNotes
    private int layout;
    private List<NotesModel> noteList;

    public NotesAdapter(MainActivity context, int layout, List<NotesModel> noteList) {
        this.context = context;
        this.layout = layout;
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return noteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView textViewNote;
        ImageView imageViewEdit;
        ImageView imageViewDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder.textViewNote = convertView.findViewById(R.id.textViewNameNote);
            viewHolder.imageViewDelete = convertView.findViewById(R.id.imageViewDelete);
            viewHolder.imageViewEdit = convertView.findViewById(R.id.imageViewEdit);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Lấy giá trị
        final NotesModel notes = noteList.get(position);
        viewHolder.textViewNote.setText(notes.getNameNote());

        // Bắt sự kiện khi nhấn vào nút chỉnh sửa
        viewHolder.imageViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Cập nhật " + notes.getNameNote(), Toast.LENGTH_SHORT).show();
                context.DialogCapNhatNotes(notes.getNameNote(), notes.getIdNote());
            }
        });
        // Bắt sự kiện khi nhấn vào nút xóa Notes
        viewHolder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gọi Dialog xác nhận xóa từ MainActivity
                context.DialogDelete(notes.getNameNote(), notes.getIdNote());
            }
        });


        return convertView;
    }
}
