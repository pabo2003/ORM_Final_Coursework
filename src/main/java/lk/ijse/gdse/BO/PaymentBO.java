package lk.ijse.gdse.BO;

import lk.ijse.gdse.DTO.PaymentDTO;

public interface PaymentBO extends SuperBO {
    public boolean save(PaymentDTO dto) throws Exception;

    public boolean update(PaymentDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;
}
