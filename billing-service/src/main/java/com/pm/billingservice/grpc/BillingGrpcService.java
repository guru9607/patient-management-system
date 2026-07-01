package com.pm.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    // StreamObserver helps us to do back and forth communiation
    public void createBillingAccount(BillingRequest billingRequest,
        StreamObserver<BillingResponse> responseObserver){

        log.info("createBillingAccount request received {}", billingRequest.toString());

        // Business logic => e.g. save to database, perform calculation, etc.

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("1234")
                .setStatus("ACTIVE")
                .build();

        //give response back to client, as many as you want
        responseObserver.onNext(response);

        // completing the connection requests
        responseObserver.onCompleted();
    }
}
