package com.dftc.libonvif.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * █████ ▒ █    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 * ▒  ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 * ░      ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 * ░  ░    ░░░ ░ ░ ░        ░ ░░ ░
 * ░      ░ ░      ░  ░
 * ░
 * Created by Administrator on 2017/10/13 0013
 */
public class CameraTimeMessage implements Parcelable {

    public static final Parcelable.Creator<CameraTimeMessage> CREATOR = new Parcelable.Creator<CameraTimeMessage>() {
        @Override
        public CameraTimeMessage createFromParcel(Parcel parcel) {
            return new CameraTimeMessage(parcel);
        }

        @Override
        public CameraTimeMessage[] newArray(int i) {
            return new CameraTimeMessage[i];
        }
    };
    private static CameraTimeMessage INSTANCE;
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public int second;

    private CameraTimeMessage() {
    }


    public CameraTimeMessage(Parcel parcel) {
        this.year = parcel.readInt();
        this.month = parcel.readInt();
        this.day = parcel.readInt();
        this.hour = parcel.readInt();
        this.minute = parcel.readInt();
        this.second = parcel.readInt();
    }

    public static CameraTimeMessage getInstance(Date date) {
        if (INSTANCE == null) {
            INSTANCE = new CameraTimeMessage();
        }
        // TODO: 2016/7/17 0017 format  date to CameraTimeMessage
        //因为onvif对应的库没有使用本类
        return INSTANCE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(year);
        parcel.writeInt(month);
        parcel.writeInt(day);
        parcel.writeInt(hour);
        parcel.writeInt(minute);
        parcel.writeInt(second);
    }
}
