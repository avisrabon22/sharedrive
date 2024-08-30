package com.avijit.sharedrive.Service;

import org.springframework.http.codec.multipart.FilePart;

public interface FileHandlingInterface {
    public void uploadFile(FilePart file);

}
