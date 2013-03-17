function getUpgradedStatus(status) {
	if (status === 'TODO') {
		return 'IN_PROGRESS';	
	} else if (status === 'IN_PROGRESS') {
			return 'TO_VERIFY';
	} else if (status === 'TO_VERIFY') {
			return 'DONE';
	} else 
		alert('task is done!');
	return status;
}

function getDowngradedStatus(status) {
	if (status === 'DONE') {
		return 'TO_VERIFY';	
	} else if (status === 'TO_VERIFY') {
			return 'IN_PROGRESS';
	} else if (status === 'IN_PROGRESS') {
			return 'TODO';
	} else 
		return status;
}