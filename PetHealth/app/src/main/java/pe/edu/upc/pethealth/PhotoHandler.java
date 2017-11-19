package pe.edu.upc.pethealth;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import pe.edu.upc.pethealth.activities.AddPetActivity;

/**
 * Created by jadis on 18/11/2017.
 */

public class PhotoHandler implements PictureCallback {

    private final Context context;

    public PhotoHandler(Context context) {
        this.context = context;
    }

    @Override
    public void onPictureTaken(byte[] bytes, Camera camera) {

        File pictureFileDir = getDir();

        if (!pictureFileDir.exists() && !pictureFileDir.mkdirs()) {
            Log.d("AddPetActvity","Can't create directory to save image.");
            Toast.makeText(context, "Can't create directory to save image.", Toast.LENGTH_LONG).show();
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String date = dateFormat.format(new Date());
        String photoFile = "Picture_"+ date + ".jpg";

        String filename = pictureFileDir.getPath() + File.separator + photoFile;

        File pictureFile = new File(filename);

        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            fos.write(bytes);
            fos.close();
            Toast.makeText(context,"New Image Saved: " + photoFile, Toast.LENGTH_LONG).show();
        }catch (Exception error) {
            Log.d("AddPetActivity","File" + filename + "not saved: " +error.getMessage());
            Toast.makeText(context, "Image Could not be saved.", Toast.LENGTH_LONG).show();

        }
    }

    public File getDir() {
        File sdDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return new File(sdDir, "PetHealth");
    }
}