package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
@Controller
public class CountryController {
	@Autowired
	CountryRepository repository;
	
	@RequestMapping(path = "/country", method = RequestMethod.GET)
	public String viewPage(Model model) {
		
		//登録後、検索処理を行って画面表示
		model.addAttribute("countries",repository.findAll());
		
		return "country";
	}
	
	@RequestMapping(path = "/country", method = RequestMethod.POST)
	public String addPage(Model model,String name,String tairiku, int population) {
		
		//1 エンティティのインスタンス「kuni」を作成
		//(赤線が出るときはインポート)
		Country kuni = new Country();
		
		//2　インスタンスに値をセット
		kuni.setName(name);
		kuni.setTairiku(tairiku);
		kuni.setPopulation(population);
		
		//3　リポジトリのsaveメソッドを使って保存
		repository.save(kuni);
		
		//登録後、後処理を行って画面表示
		model.addAttribute("countries",repository.findAll());
		
		return "country";
	}
}