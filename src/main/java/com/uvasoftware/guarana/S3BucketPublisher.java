package com.uvasoftware.guarana;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class S3BucketPublisher implements PersistenceCapable {
  private final String bucketName;
  private final S3Client s3;

  S3BucketPublisher(String bucketName) {
    this.bucketName = bucketName;
    this.s3 = S3Client.create();
  }

  @Override
  public void persist(String path, String contents) {
    s3.putObject(
      PutObjectRequest.builder().bucket(bucketName).key(path).build(),
      RequestBody.fromString(contents)
    );
  }
}
