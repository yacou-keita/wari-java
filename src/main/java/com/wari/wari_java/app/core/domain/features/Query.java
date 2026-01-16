package com.wari.wari_java.app.core.domain.features;

public interface Query<Request,Response> {
   Response execute(Request request);
}
