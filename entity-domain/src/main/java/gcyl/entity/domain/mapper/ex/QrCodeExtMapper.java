package gcyl.entity.domain.mapper.ex;

import gcyl.entity.domain.model.QrCode;
import gcyl.entity.domain.model.QrCodeExample;

import java.util.List;

public interface QrCodeExtMapper {

    List<QrCode> selectByExample(QrCodeExample example);

}