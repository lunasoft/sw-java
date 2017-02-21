package Utils.Requests;

import Exceptions.AuthException;
import Exceptions.GenaralException;
import Utils.Requests.IRequest;
import Utils.Responses.IResponse;

/**
 * Created by asalvio on 08/02/2017.
 */
public interface IRequestor {
    public IResponse sendRequest(IRequest request) throws GenaralException, AuthException;

}
