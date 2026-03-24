package com.app.hikaribase.repository;

import com.app.hikaribase.model.ConnectionDetails;

public interface ConnectionRepository {

    int save(ConnectionDetails details);
}
