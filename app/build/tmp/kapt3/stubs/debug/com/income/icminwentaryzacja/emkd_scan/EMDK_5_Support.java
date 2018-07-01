package com.income.icminwentaryzacja.emkd_scan;

@kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \'2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004$%&\'B\u000f\b\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\fJ\b\u0010\"\u001a\u00020\u0016H\u0003J\u0006\u0010#\u001a\u00020\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006("}, d2 = {"Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support;", "Lcom/symbol/emdk/EMDKManager$EMDKListener;", "Lcom/symbol/emdk/barcode/Scanner$StatusListener;", "Lcom/symbol/emdk/barcode/Scanner$DataListener;", "_ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_barcodeManager", "Lcom/symbol/emdk/barcode/BarcodeManager;", "_emdkManager", "Lcom/symbol/emdk/EMDKManager;", "_onRead", "Lcom/income/icminwentaryzacja/emkd_scan/OnScannerRead;", "_scanner", "Lcom/symbol/emdk/barcode/Scanner;", "isScannerFinishRead", "", "isScannerFinishRead$app_debug", "()Z", "setScannerFinishRead$app_debug", "(Z)V", "onClosed", "", "onData", "scanDataCollection", "Lcom/symbol/emdk/barcode/ScanDataCollection;", "onOpened", "emdkManager", "onScannerReadChanged", "onStatus", "statusData", "Lcom/symbol/emdk/barcode/StatusData;", "registerScannerListener", "onRead", "runScanAfterIDLE", "unregisterScannerListeners", "AsynTaskStateIdle", "AsyncDataUpdate", "AsyncStatusUpdate", "Companion", "app_debug"})
public final class EMDK_5_Support implements com.symbol.emdk.EMDKManager.EMDKListener, com.symbol.emdk.barcode.Scanner.StatusListener, com.symbol.emdk.barcode.Scanner.DataListener {
    private com.symbol.emdk.EMDKManager _emdkManager;
    private com.symbol.emdk.barcode.BarcodeManager _barcodeManager;
    private volatile com.symbol.emdk.barcode.Scanner _scanner;
    private volatile com.income.icminwentaryzacja.emkd_scan.OnScannerRead _onRead;
    private boolean isScannerFinishRead;
    private final android.content.Context _ctx = null;
    @org.jetbrains.annotations.Nullable()
    private static com.income.icminwentaryzacja.emkd_scan.EMDK_5_Support emdkSupport;
    public static final com.income.icminwentaryzacja.emkd_scan.EMDK_5_Support.Companion Companion = null;
    
    public final boolean isScannerFinishRead$app_debug() {
        return false;
    }
    
    public final void setScannerFinishRead$app_debug(boolean p0) {
    }
    
    @java.lang.Override()
    public void onData(@org.jetbrains.annotations.NotNull()
    com.symbol.emdk.barcode.ScanDataCollection scanDataCollection) {
    }
    
    @java.lang.Override()
    public void onStatus(@org.jetbrains.annotations.NotNull()
    com.symbol.emdk.barcode.StatusData statusData) {
    }
    
    @java.lang.Override()
    public void onClosed() {
    }
    
    @java.lang.Override()
    public void onOpened(@org.jetbrains.annotations.NotNull()
    com.symbol.emdk.EMDKManager emdkManager) {
    }
    
    private final void onScannerReadChanged() {
    }
    
    public final void registerScannerListener(@org.jetbrains.annotations.NotNull()
    com.income.icminwentaryzacja.emkd_scan.OnScannerRead onRead) {
    }
    
    public final void unregisterScannerListeners() {
    }
    
    private final synchronized void runScanAfterIDLE() {
    }
    
    private EMDK_5_Support(android.content.Context _ctx) throws java.lang.Exception {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J!\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support$AsyncDataUpdate;", "Landroid/os/AsyncTask;", "Lcom/symbol/emdk/barcode/ScanDataCollection;", "Ljava/lang/Void;", "", "(Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support;)V", "doInBackground", "params", "", "([Lcom/symbol/emdk/barcode/ScanDataCollection;)Ljava/lang/String;", "onPostExecute", "", "result", "app_debug"})
    public final class AsyncDataUpdate extends android.os.AsyncTask<com.symbol.emdk.barcode.ScanDataCollection, java.lang.Void, java.lang.String> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.lang.String doInBackground(@org.jetbrains.annotations.NotNull()
        com.symbol.emdk.barcode.ScanDataCollection... params) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.NotNull()
        java.lang.String result) {
        }
        
        public AsyncDataUpdate() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support$AsynTaskStateIdle;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "(Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support;)V", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Void;", "app_debug"})
    public final class AsynTaskStateIdle extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Void> {
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... params) {
            return null;
        }
        
        public AsynTaskStateIdle() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005\u00a2\u0006\u0002\u0010\u0005J!\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support$AsyncStatusUpdate;", "Landroid/os/AsyncTask;", "Lcom/symbol/emdk/barcode/StatusData;", "Ljava/lang/Void;", "", "(Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support;)V", "doInBackground", "params", "", "([Lcom/symbol/emdk/barcode/StatusData;)Ljava/lang/String;", "onPostExecute", "", "result", "app_debug"})
    public final class AsyncStatusUpdate extends android.os.AsyncTask<com.symbol.emdk.barcode.StatusData, java.lang.Void, java.lang.String> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.lang.String doInBackground(@org.jetbrains.annotations.NotNull()
        com.symbol.emdk.barcode.StatusData... params) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.NotNull()
        java.lang.String result) {
        }
        
        public AsyncStatusUpdate() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 7}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support$Companion;", "", "()V", "<set-?>", "Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support;", "emdkSupport", "getEmdkSupport", "()Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support;", "setEmdkSupport", "(Lcom/income/icminwentaryzacja/emkd_scan/EMDK_5_Support;)V", "initEmdkSupport", "ctx", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.income.icminwentaryzacja.emkd_scan.EMDK_5_Support getEmdkSupport() {
            return null;
        }
        
        private final void setEmdkSupport(com.income.icminwentaryzacja.emkd_scan.EMDK_5_Support p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.income.icminwentaryzacja.emkd_scan.EMDK_5_Support initEmdkSupport(@org.jetbrains.annotations.NotNull()
        android.content.Context ctx) throws java.lang.Exception {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}