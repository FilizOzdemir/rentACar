package com.etiya.rentACar.business.concretes;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.etiya.rentACar.business.abstracts.DamageService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.DeleteDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.UpdateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.DamageDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;

import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.DamageDao;
import com.etiya.rentACar.entities.Damage;



@Service
public class DamageManager implements DamageService {

	private DamageDao damageDao;
	private ModelMapperService modelMapperService;


	public DamageManager(DamageDao damagedao, ModelMapperService modelMapperService) {

		this.damageDao = damagedao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateDamageRequest createDamageRequest) {
		Damage damage = this.modelMapperService.forRequest().map(createDamageRequest, Damage.class);
		this.damageDao.save(damage);
		return new SuccessResult(BusinessMessages.DamageMessages.DAMAGE_ADDED);// hasar eklendi
	}

	@Override
	public Result update(UpdateDamageRequest updateDamageRequest) {
		
		Damage damage = this.modelMapperService.forRequest().map(updateDamageRequest, Damage.class);
		this.damageDao.save(damage);
		return new SuccessResult(BusinessMessages.DamageMessages.DAMAGE_UPDATED);// hasar güncellendi
	}

	@Override
	public Result delete(DeleteDamageRequest deleteDamageRequest) {
		this.damageDao.deleteById(deleteDamageRequest.getId());
		return new SuccessResult(BusinessMessages.DamageMessages.DAMAGE_DELETED);// hasar silindi
	}

	@Override
	public DamageDto getById(int id) {
		Damage damage = this.damageDao.getById(id);
		DamageDto response = this.modelMapperService.forDto().map(damage, DamageDto.class);
		return response;
	}

	@Override
	public DataResult<List<ListDamageDto>> getAll() {
		List<Damage> damages = this.damageDao.findAll();
		List<ListDamageDto> response = damages.stream()
				.map(damage -> this.modelMapperService.forDto().map(damage, ListDamageDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListDamageDto>>(response);
	}

	@Override
	public DataResult<List<ListDamageDto>> getAllByCarId(int carId) {
		List<Damage> damages = this.damageDao.getAllByCarId(carId);
		List<ListDamageDto> response = damages.stream()
				.map(damage -> this.modelMapperService.forDto().map(damage, ListDamageDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListDamageDto>>(response);
	}

	@Override
	public DataResult<List<ListDamageDto>> getAllPaged(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		List<Damage> damages =this.damageDao.findAll(pageable).getContent();
		List<ListDamageDto> response = damages.stream()
				.map(damage -> this.modelMapperService.forDto().map(damage, ListDamageDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<ListDamageDto>>(response);
	}

	@Override
	public DataResult<List<ListDamageDto>> getAllSorted(String field, String option) {
		Sort sort= Sort.by(Sort.Direction.valueOf(option), field);
        List<Damage> damages = this.damageDao.findAll(sort);
        List<ListDamageDto> response = damages.stream().map(damage -> this.modelMapperService.forDto().map(damage, ListDamageDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListDamageDto>>(response);
	}

	
}
