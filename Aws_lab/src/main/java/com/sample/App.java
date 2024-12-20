package com.sample;

// snippet-start:[s3.java2.list_objects.import]

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {

//        Class.forName("software.amazon.awssdk.regions.Region");

        // snippet-start:[s3.java2.s3_bucket_ops.region]
        Region region = Region.AP_NORTHEAST_1;

        //建立客戶端
        ListBucketsResponse listBucketsResponse;
        try (S3Client s3 = S3Client.builder()
                .region(region)
                .build()) {

            //使用客戶端方法
            ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
            listBucketsResponse = s3.listBuckets(listBucketsRequest);
        }

        listBucketsResponse.buckets().stream().forEach(x -> System.out.println(x.name()));

    }
}

