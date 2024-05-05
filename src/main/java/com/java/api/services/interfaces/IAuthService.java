package com.java.api.services.interfaces;

import com.java.api.models.AuthModel;
import com.java.api.models.ResponseModel;
import com.java.api.models.TokenModel;
import com.java.api.models.AddClientModel;

public interface IAuthService {
    public ResponseModel<TokenModel> login(AuthModel credentials);
    public ResponseModel<TokenModel> register(AddClientModel clientModel);
}
