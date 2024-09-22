package com.interceptor;


import com.dao.TUserGoodsDAO;
import com.model.TUser;
import com.model.TUserGoods;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class GoodsInterceptor implements Interceptor {
	private TUserGoodsDAO tUserGoodsDAO ;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init() {
		// TODO Auto-generated method stub
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		TUser user = (TUser) arg0.getInvocationContext().getSession().get("user");
		if(user!=null){
			System.out.println("存在session---------------------");
			/*int goods_id = Integer.valueOf(((String[])arg0.getInvocationContext().getParameters().get("goodsId"))[0]);
			int user_id = user.getUserId();
			TUserGoods tUserGoods = new TUserGoods();
			tUserGoods.setUser_id(user_id);
			tUserGoods.setGoods_id(goods_id);
			tUserGoodsDAO.save(tUserGoods);*/
		}
		return arg0.invoke();
	}

	public TUserGoodsDAO gettUserGoodsDAO() {
		return tUserGoodsDAO;
	}

	public void settUserGoodsDAO(TUserGoodsDAO tUserGoodsDAO) {
		this.tUserGoodsDAO = tUserGoodsDAO;
	}
}
