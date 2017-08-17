/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alanmrace.jimzmlparser.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.XZInputStream;
import org.tukaani.xz.XZOutputStream;

/**
 *
 * @author alan.race
 */
public class XZDataTransform implements DataTransform {
    
    static protected final int BYTE_BUFFER_SIZE = 2 ^ 20;
    
    @Override
    public byte[] forwardTransform(byte[] data) throws DataFormatException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        XZOutputStream gzos = null;
        
        try {
            gzos = new XZOutputStream(outputStream, new LZMA2Options());
            gzos.write(data, 0, data.length);
            gzos.finish();
        } catch (IOException ex) {
            Logger.getLogger(XZDataTransform.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                gzos.close();
            } catch (IOException ex) {
                Logger.getLogger(XZDataTransform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(gzos != null) {
            try {
                outputStream.flush();
            } catch (IOException ex) {
                Logger.getLogger(XZDataTransform.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return outputStream.toByteArray();
        }
        
        return null;
    }

    @Override
    public byte[] reverseTransform(byte[] data) throws DataFormatException {
        try {
            XZInputStream xzInputStream = new XZInputStream(
                    new ByteArrayInputStream(data));
            
            List<Byte> uncompressedData = new ArrayList<Byte>(data.length);
            
            int uncompressed = 0;
            int firstByte;
            
            while((firstByte = xzInputStream.read()) != -1 && 
                    (uncompressed = xzInputStream.available()) > 0) {
                // Take into account the first byte
                uncompressed++;
                
                byte[] temp = new byte[uncompressed]; // 2^20
                temp[0] = (byte) firstByte;

                xzInputStream.read(temp, 1, temp.length-1);

                for (int i = 0; i < uncompressed; i++) {
                    uncompressedData.add(temp[i]);
                }
            }
                        
            xzInputStream.close();

            byte[] uncompressedBytes = new byte[uncompressedData.size()];
            
            for (int i = 0; i < uncompressedData.size(); i++) {
                uncompressedBytes[i] = uncompressedData.get(i);
            }
            
            return uncompressedBytes;
        } catch (IOException ex) {
            Logger.getLogger(XZDataTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}