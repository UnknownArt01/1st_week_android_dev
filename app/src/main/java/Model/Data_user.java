package Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Data_user implements Parcelable {
    private String nama, umur, alamat;

    public Data_user(String nama, String umur, String alamat) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
    }
    public Data_user() {

    }

    protected Data_user(Parcel in) {
        nama = in.readString();
        umur = in.readString();
        alamat = in.readString();
    }

    public static final Creator<Data_user> CREATOR = new Creator<Data_user>() {
        @Override
        public Data_user createFromParcel(Parcel in) {
            return new Data_user(in);
        }

        @Override
        public Data_user[] newArray(int size) {
            return new Data_user[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(umur);
        parcel.writeString(alamat);
    }
}
