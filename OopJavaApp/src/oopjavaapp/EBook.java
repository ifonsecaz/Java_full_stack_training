/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopjavaapp;

/**
 *
 * @author ifons
 */
public class EBook extends Book{
    private String fileFormat;
    private int fileSize;
    
    public EBook(String title, String author, int isbn,String fileformat,int fileSize) {
        super(title, author, isbn, -1);
        this.fileFormat=fileformat;
        this.fileSize=fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        StringBuilder cad =new StringBuilder();
        cad.append(super.toString());
        cad.append("\nFile format= "+fileFormat);
        cad.append("\nFile size= "+fileSize);
        return cad.toString();
    }
        
}
