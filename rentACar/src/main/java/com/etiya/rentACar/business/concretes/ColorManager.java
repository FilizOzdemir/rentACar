package com.etiya.rentACar.business.concretes;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.ColorDao;
import com.etiya.rentACar.entities.Color;


@Service
public class ColorManager implements ColorService {

	private ColorDao colorDao;
	private ModelMapperService modelMapperService;

	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateColorRequest createColorRequest) {
	
		String colorName = createColorRequest.getName();
		checkIfColorExists(colorName);
		
		Color color=this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult(BusinessMessages.ColorMessages.COLOR_ADDED);//renk eklendi
	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		
		Color color=this.modelMapperService.forRequest().map(updateColorRequest, Color.class);
		this.colorDao.save(color);
		return new SuccessResult(BusinessMessages.ColorMessages.COLOR_UPDATED);//renk g??ncellendi
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		
		int colorId = deleteColorRequest.getId();
		this.colorDao.deleteById(colorId);
		return new SuccessResult(BusinessMessages.ColorMessages.COLOR_DELETED);//renk silindi
	}


	@Override
	public DataResult<List<ListColorDto>> getAll() {//t??m??n?? listeleme
		List<Color> colors= this.colorDao.findAll();
		List<ListColorDto> response=colors.stream().map(color->this.modelMapperService.forDto().map(color, ListColorDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListColorDto>>(response);
	}

    private void checkIfColorExists(String colorName) {
        if (this.colorDao.existsColorByNameIgnoreCase(colorName)) {
            throw new BusinessException(BusinessMessages.ColorMessages.COLOR_EXIST);//Girdi??iniz Renk Mevcuttur !
        }
    }


	
}
