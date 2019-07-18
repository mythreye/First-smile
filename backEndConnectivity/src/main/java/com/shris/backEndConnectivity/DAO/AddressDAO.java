package com.shris.backEndConnectivity.DAO;

import java.util.List;

import com.shris.backEndConnectivity.model.Address;

public interface AddressDAO {

	boolean insertAddress(Address address);

	boolean updateAddress(Address address);

	boolean deleteOneAddress(int addressid);

	Address SelectOneAddress(int addressid);

	List<Address> SelectAddress(int custid);

}
