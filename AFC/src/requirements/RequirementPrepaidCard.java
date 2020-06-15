package requirements;

import java.sql.SQLException;

import interactor.RequirementInterface;

public class RequirementPrepaidCard implements RequirementInterface {

	@Override
	public String passEntering(String certificateId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String passExiting(String certificateId, double fee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
