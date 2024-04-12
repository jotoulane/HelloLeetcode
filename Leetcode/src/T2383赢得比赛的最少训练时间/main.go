package T2383赢得比赛的最少训练时间

func minNumberOfHours(initialEnergy int, initialExperience int, energy []int, experience []int) int {
	res := 0
	for i := 0; i < len(energy); i++ {
		if initialEnergy <= energy[i] {
			res += energy[i] + 1 - initialEnergy
			initialEnergy = energy[i] + 1 // 补到刚好超过
		}
		initialEnergy -= energy[i]

		if initialExperience <= experience[i] {
			res += experience[i] + 1 - initialExperience
			initialExperience = experience[i] + 1 // 补到刚好超过
		}
		initialExperience += experience[i]
	}
	return res
}
