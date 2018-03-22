package com.dftc.libonvif.model;

import android.os.Parcel;
import android.os.Parcelable;

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
public class CameraIpMessage implements Parcelable {
    public static final Parcelable.Creator<CameraIpMessage> CREATOR = new Parcelable.Creator<CameraIpMessage>() {
        @Override
        public CameraIpMessage createFromParcel(Parcel parcel) {
            return new CameraIpMessage(parcel);
        }

        @Override
        public CameraIpMessage[] newArray(int i) {
            return new CameraIpMessage[i];
        }
    };
    public int mode;//0:dhcp;1:固定ip
    public String ipAddr;

    public CameraIpMessage() {
    }

    public CameraIpMessage(Parcel parcel) {
        this.mode = parcel.readInt();
        this.ipAddr = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mode);
        parcel.writeString(ipAddr);
    }

}
