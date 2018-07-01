package de.wasiakgruppe.ann.abstraction.norms;

import java.lang.System;

/**
 * This interface describes information about the person 
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/norms/IPersonInfo;", "", "birthDate", "Lorg/joda/time/DateTime;", "getBirthDate", "()Lorg/joda/time/DateTime;", "gender", "Lde/wasiakgruppe/ann/abstraction/domain/Gender;", "getGender", "()Lde/wasiakgruppe/ann/abstraction/domain/Gender;", "Companion", "abstraction_debug"})
public abstract interface IPersonInfo {
    public static final de.wasiakgruppe.ann.abstraction.norms.IPersonInfo.Companion Companion = null;
    
    /**
     * Gender of the person 
     */
    @org.jetbrains.annotations.NotNull()
    public abstract de.wasiakgruppe.ann.abstraction.domain.Gender getGender();
    
    /**
     * Birth date of the person 
     */
    @org.jetbrains.annotations.Nullable()
    public abstract org.joda.time.DateTime getBirthDate();
    
    /**
     * Empty person info object for testing purposes 
     */
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/norms/IPersonInfo$Companion;", "", "()V", "EmptyPersonInfo", "abstraction_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lde/wasiakgruppe/ann/abstraction/norms/IPersonInfo$Companion$EmptyPersonInfo;", "Lde/wasiakgruppe/ann/abstraction/norms/IPersonInfo;", "()V", "birthDate", "", "getBirthDate", "()Ljava/lang/Void;", "gender", "Lde/wasiakgruppe/ann/abstraction/domain/Gender;", "getGender", "()Lde/wasiakgruppe/ann/abstraction/domain/Gender;", "abstraction_debug"})
        public static final class EmptyPersonInfo implements de.wasiakgruppe.ann.abstraction.norms.IPersonInfo {
            @org.jetbrains.annotations.NotNull()
            private static final de.wasiakgruppe.ann.abstraction.domain.Gender gender = null;
            @org.jetbrains.annotations.Nullable()
            private static final java.lang.Void birthDate = null;
            public static final de.wasiakgruppe.ann.abstraction.norms.IPersonInfo.Companion.EmptyPersonInfo INSTANCE = null;
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public de.wasiakgruppe.ann.abstraction.domain.Gender getGender() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            @java.lang.Override()
            public java.lang.Void getBirthDate() {
                return null;
            }
            
            private EmptyPersonInfo() {
                super();
            }
        }
    }
}