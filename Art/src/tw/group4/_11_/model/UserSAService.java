package tw.group4._11_.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSAService {

	private UserSADao uDao;

	@Autowired
	public UserSAService(UserSADao uDao) {
		this.uDao = uDao;
	}
	
	public byte[] picSaByteArray(UserSABean uBean) {
		return uDao.picSaByteArray(uBean);
	}
	
	public List<UserSABean> selectAll(){
		return uDao.selectAll();
	}
	
	public List<UserSABean> search(String word){
		return uDao.search(word);
	}
	
	public List<UserSABean> selectAllSA(){
		List<UserSABean> list = uDao.selectAll();
		List<UserSABean> listNew = new ArrayList<UserSABean>();
		
		for (UserSABean item: list) {
			System.out.println(item.getPic_SA());
			System.out.println(item.getName_SA());
			try {
				byte[] byteArray = item.getPic_SA().getBytes(1, (int) item.getPic_SA().length());
				item.setPic2_SA(Base64.encodeBase64String(byteArray));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			listNew.add(item);
		}
		return listNew;
	}
	
	public List<UserSABean> selectIdSA(int id){
		List<UserSABean> list = uDao.searchID(id);
		List<UserSABean> listNew = new ArrayList<UserSABean>();
		
		for (UserSABean item: list) {
			System.out.println(item.getPic_SA());
			System.out.println(item.getName_SA());
			try {
				byte[] byteArray = item.getPic_SA().getBytes(1, (int) item.getPic_SA().length());
				item.setPic2_SA(Base64.encodeBase64String(byteArray));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			listNew.add(item);
		}
		return listNew;
	}
}
