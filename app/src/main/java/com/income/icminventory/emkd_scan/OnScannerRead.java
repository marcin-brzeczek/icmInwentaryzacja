package com.income.icminventory.emkd_scan;

public interface OnScannerRead {
    void onReadData(String text);
    void onReadStatus(String text);
    void exceptionMessage(String text);
}
