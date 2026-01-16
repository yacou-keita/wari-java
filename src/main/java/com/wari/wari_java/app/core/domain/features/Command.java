package com.wari.wari_java.app.core.domain.features;

public interface Command<Request> {
   void execute(Request request);
}
