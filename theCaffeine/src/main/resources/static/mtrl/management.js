/**
 * 
 */
 
	mtrlSaveBtn1.addEventListener("click", e=> {
		saveReq();
	})

	// 등록 요청
	function saveReq() {
		const cliCd= mtrl_management_clicd.value;
		const mtCd = mtrl_management_cd.value;
		const mtDiv = mtrl_management_div.value;
		const mtName = mtrl_management_name.value;
		const cost = mtrl_management_cost.value;
		const unit = mtrl_management_unit.value;
		const expDt = mtrl_management_expdt.value;
		const leadtm = mtrl_management_leadtm.value;
		const safeStkRate = mtrl_management_safestkrate.value;
		let param = {cliCd, mtCd, mtDiv, mtName, cost, unit, expDt, leadtm, safeStkRate};
		console.log(param);
		fetch("/ajax/mtrl",{
			method : "post",
			headers: {
			      "Content-Type": "application/json",
			    },
			body : JSON.stringify(param)
		})
		.then(res => res.json())
		.then(res => saveRes(res))
	}
	
	// 등록 응답
	function saveRes(res) {
		alert("등록이 완료되었습니다!");
		location.href= "/material/management"
	}