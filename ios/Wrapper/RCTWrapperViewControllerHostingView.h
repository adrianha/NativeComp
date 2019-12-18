//
//  RCTWrapperViewControllerHostingView.h
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface RCTWrapperViewControllerHostingView : UIView

@property (nonatomic, retain, nullable) UIViewController *contentViewController;

#pragma mark - Restrictions

- (void)addSubview:(UIView *)view NS_UNAVAILABLE;
- (void)insertSubview:(UIView *)view atIndex:(NSInteger)index NS_UNAVAILABLE;
- (void)insertSubview:(UIView *)view aboveSubview:(UIView *)siblingSubview NS_UNAVAILABLE;
- (void)insertSubview:(UIView *)view belowSubview:(UIView *)siblingSubview NS_UNAVAILABLE;

@end

NS_ASSUME_NONNULL_END
