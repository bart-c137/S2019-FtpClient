/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sxu.bart.ftpclient.ftp;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author bartb
 */
public class FtpServer {
    private FTPClient ftpClient;
    
    private String host;
    private int port;
    private String user;
    private String password;
    
    private IDirectoryManager directoryManager;
    private IFileManager fileManager;
    
    public FtpServer() {}
    
    public FtpServer(String host, int port, String user, String password) {
        setHost(host);
        setPort(port);
        setUser(user);
        setPassword(password);
    }
    
    public String getHost() {
        return host;
    }
    
    public void setHost(String host) {
        this.host = host;
    }
    
    public int getPort() {
        return port;
    }
    
    public void setPort(int port) {
        this.port = port;
    }
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    private String getPassword() {
        return password;
    }
    
    public void connect() throws IOException {
        ftpClient = new FTPClient();
        ftpClient.connect(getHost());
        ftpClient.login(getUser(), getPassword());
        
        int reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            
            throw new IOException("The server refused to connecto for some reason.");
        }
    }
    
    public void disconnect() throws IOException {
        ftpClient.logout();
        ftpClient.disconnect();
    }
    
    public String[] getFiles() throws IOException {
        FTPFile[] files = ftpClient.listFiles();
        String[] fileNames = new String[files.length];
        
        int index = 0;
        for(FTPFile file : files) {
            fileNames[index] = file.getName();
            index++;
        }
        
        return fileNames;
    }
}
